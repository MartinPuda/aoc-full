(ns aoc-full.aoc17.day02
  (:require [clojure.string :as str]
            [clojure.math.combinatorics :as combo]))

(defn get-input []
  (->> (str/split-lines (slurp "resources/public/aoc17/input02.txt"))
       (map #(->> (str/split % #"\s+")
                  (map parse-double)))))

(defn part1 [input]
  (transduce (map #(- (apply max %) (apply min %)))
             +
             input))

(defn cx [xs]
  (->> (combo/combinations (sort > xs) 2)
       (filter #(zero? (apply mod %)))
       first
       (apply /)))

(defn part2 [input]
  (transduce (map cx) + input))

;;;; results
; 47136.0
; 250.0