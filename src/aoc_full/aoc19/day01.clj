(ns aoc-full.aoc19.day01
  (:require [clojure.string :as str]
            [clojure.math :as m]))

(defn get-input []
  (map parse-long
       (-> (slurp "resources/public/aoc19/input01.txt")
           (str/split #"\s+"))))

(defn fuel [num]
  (-> num
      (/ 3)
      (m/floor)
      (- 2)))

(defn fuel-for-fuel [num]
  (->> (iterate fuel num)
       rest
       (take-while pos?)
       (apply +)))

(defn part1 [input]
  (->> input
       (map fuel)
       (apply +)))

(defn part2 [input]
  (->> input
       (map fuel-for-fuel)
       (apply +)))

;;;; results
; 3152375
; 4725720