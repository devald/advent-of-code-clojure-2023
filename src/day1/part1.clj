(ns day1.part1
  (:require [clojure.string :as str]
            [day1.common :as day1-common]))

(defn read-file-and-sum
  "This function reads the contents of a file, and then performs a two-digit extraction.
  Finally, it sums up the resulting numbers."
  [file-path]
  (->>
    (slurp file-path)
    (str/split-lines)
    (map day1-common/extract-first-last-digits)
    (reduce +)))

(println
  (read-file-and-sum "src/day1/input.txt"))
