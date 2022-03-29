(ns aoc-full.aoc17.day01
  (:require [clojure.string :as str]))

(defn get-input []
  (->> (str/trim (slurp "resources/public/aoc17/input01.txt"))
       (mapv #(Character/digit ^char % 10))))

(defn part1 [input]
  (->> (take (inc (count input)) (cycle input))
       (partition 2 1)
       (filter #(apply = %))
       (map first)
       (apply +)))

(defn part2 [input]
  (let [len (count input)
        half (/ len 2)]
    (->> (map-indexed vector input)
         (filter (fn [[i num]]
                   (= num (get input (mod (+ i half) len)))))
         (map second)
         (apply +))))

;;;; results
; 1136
; 1092