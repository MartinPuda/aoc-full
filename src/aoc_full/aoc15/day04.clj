(ns aoc-full.aoc15.day04
  (:import (java.security MessageDigest))
  (:require [clojure.string :as str]))

(defn md5 [s]
  (let [bytes (.digest (MessageDigest/getInstance "MD5")
                       (.getBytes s "UTF-8"))]
    (format "%032x" (BigInteger. 1 bytes))))

(defn part [start]
  (->> (rest (range))
       (pmap #(vector % (md5 (str "yzbqklnj" %))))
       (drop-while (complement (fn [[i hsh]] (str/starts-with? hsh start))))
       ffirst))

(comment
  (part "00000")
  (part "000000"))

;;;; results
; 282749
; 9962624
