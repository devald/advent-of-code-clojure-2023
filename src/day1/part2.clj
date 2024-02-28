(ns day1.part2
  (:require [clojure.string :as str]
            [day1.common :as day1-common]))

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

(defn convert-word-to-number
  "This function converts numeric words (e.g., 'one', 'two') within a string
  into their corresponding numerical digits (e.g., '1', '2')."
  [string]
  (let [replacement-list (partition 2 word-number-mappings)]
    (reduce #(apply str/replace %1 %2) string replacement-list)))

(defn read-file-and-sum
  "This function reads the content of a file, converts any numeric words within the string
  into their corresponding numerical digits, and then performs a two-digit extraction.
  Finally, it sums up the resulting numbers."
  [file-path]
  (->>
    (slurp file-path)
    (convert-word-to-number)
    (str/split-lines)
    (map day1-common/extract-first-last-digits)
    (reduce +)))

(println
  (read-file-and-sum "src/day1/input.txt"))
