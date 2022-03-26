(ns aoc-full.aoc15.day01
  (:require [clojure.string :as str]))

(defn get-input []
  (slurp "resources/public/aoc15/input01.txt"))

(defn part1 [input]
  (let [f (frequencies input)]
    (- (f \() (f \)))))

(defn part2 [input]
  (reduce (fn [state [i c]]
            (let [new-state (if (= c \()
                              (inc state)
                              (dec state))]
              (if (= new-state -1)
                (reduced (inc i))
                new-state)))
          0
          (map-indexed vector input)))

;;;; results
; 280
; 1797


