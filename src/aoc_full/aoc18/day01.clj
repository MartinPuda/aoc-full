(ns aoc-full.aoc18.day01
  (:require [clojure.string :as str]))

(defn get-input []
  (->> (str/split (slurp "resources/public/aoc18/input01.txt") #"\s+")
       (map parse-long)))

(defn part1 [input]
  (apply + input))

(defn part2 [input]
  (reduce (fn [{:keys [log f]} num]
            (let [new-f (+ f num)]
              (if (log new-f)
                (reduced new-f)
                {:log (conj log new-f) :f new-f})))
          {:log #{} :f 0}
          (cycle input)))

;;;; results
; 531
; 76787
