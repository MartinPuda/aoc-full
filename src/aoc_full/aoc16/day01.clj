(ns aoc-full.aoc16.day01
  (:require [clojure.string :as str]
            [clojure.spec.alpha :as spec]
            [clojure.spec.test.alpha :as st]
            [clojure.math :as m]))

(defn get-input []
  (str/trim (slurp "resources/public/aoc16/input01.txt")))

(defn parse-input [s]
  (->> (-> (str/replace s #"," "")
           (str/split #" "))
       (map (fn [[c & num]]
              [c (parse-long (apply str num))]))))


(defn dist [{:keys [x y]}]
  (m/round (+ (abs x) (abs y))))

(defn part1 [input]
  (let [state (reduce (fn [state [c num]]
                        (let [new-state (update state :angle + (if (= c \L) 90 -90))
                              rad (m/to-radians (new-state :angle))]
                          (-> new-state
                              (update :x + (* num (m/cos rad)))
                              (update :y + (* num (m/sin rad))))))
                      {:angle 90 :x 0 :y 0}
                      input)]
    (dist state)))

;;;; results
; 271
