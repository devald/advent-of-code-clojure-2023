(ns day1.part2
  (:require [clojure.string :as str]))

(def word-number-mappings
  (list
    #"oneight" "18"
    #"twone" "21"
    #"threeight" "38"
    #"fiveight" "58"
    #"sevenine" "79"
    #"eightwo" "82"
    #"eighthree" "83"
    #"nineight" "98"
    #"one" "1"
    #"two" "2"
    #"three" "3"
    #"four" "4"
    #"five" "5"
    #"six" "6"
    #"seven" "7"
    #"eight" "8"
    #"nine" "9"))

(defn word-to-number [string]
  (let [replacement-list (partition 2 word-number-mappings)]
    (reduce #(apply str/replace %1 %2) string replacement-list)))

(defn process-line [line]
  (when-let [matches (re-seq #"\d" line)]
    (let [first-digit (first matches)
          last-digit (last matches)
          two-digit (str first-digit last-digit)]
      (read-string two-digit))))

(defn read-file-and-process [file-path]
  (->>
    (slurp file-path)
    (word-to-number)
    (str/split-lines)
    (map process-line)
    (reduce +)))

(println
  (read-file-and-process "src/day1/input.txt"))
