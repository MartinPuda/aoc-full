(ns aoc-full.aoc20.day01
  (:require [clojure.string :as str]))

(defn get-input []
  (map parse-long
       (-> (slurp "resources/public/aoc20/input01.txt")
           (str/split #"\s+"))))

(defn part1 [input]
  (for [num input
        :when (.contains input (- 2020 num))]
    (* num (- 2020 num))))

(defn part2 [input]
  (for [num input
        num2 input
        :when (.contains input (- 2020 (+ num num2)))]
    (* num num2 (- 2020 (+ num num2)))))

;;;; results
; 157059
; 165080960