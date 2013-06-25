(ns tron.bots
  (:require [tron.core :as tron]))

(defn buzz 
  "To infinity and beyond!"
  [look {[x y] :pos}]
  {:pos [(inc x) y]})

(defn right [[x y]]
  [(inc x) y])

(defn down [[x y]]
  [x (inc y)])

(defn down-or-right
  [look {pos :pos}]
  (if (look (down pos))
    {:pos (right pos)}
    {:pos (down pos)}))

;; launch bots
(doseq [[s hue] 
        (map vector 
            [buzz down-or-right]
            (iterate #(+ % 25) 0))]
  (tron/spawn-biker s hue))