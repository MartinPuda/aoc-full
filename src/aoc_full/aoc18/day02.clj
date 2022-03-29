(ns aoc-full.aoc18.day02
  (:require [clojure.string :as str]
            [clojure.set :as s]))

(defn get-input []
  (str/split-lines (slurp "resources/public/aoc18/input02.txt")))

(defn part1 [input]
  (let [fs (map frequencies input)
        filter-count (fn [i] (->> fs
                                  (map vals)
                                  (filter #(some #{i} %))
                                  count))]
    (* (filter-count 2)
       (filter-count 3))))

(defn part2 [input]
  (let [two-strings (first (for [s1 input
                                 s2 input
                                 :when (= 1 (->> (apply map = [s1 s2])
                                                 (filter false?)
                                                 count))]
                             [s1 s2]))]
    (->> two-strings
         (apply map vector)
         (filter (fn [[a b]] (= a b)))
         (map first)
         (str/join))))

;;;; results
; 6474
; "mxhwoglxgeauywfkztndcvjqr"