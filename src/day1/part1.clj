(ns day1.part1
  (:require [clojure.string :as str]))

(defn process-line [line]
  (when-let [matches (re-seq #"\d" line)]
    (let [first-digit (first matches)
          last-digit (last matches)
          two-digit (str first-digit last-digit)]
      (read-string two-digit))))

(defn read-file-and-process [file-path]
  (->>
    (slurp file-path)
    (str/split-lines)
    (map process-line)
    (reduce +)))

(println
  (read-file-and-process "src/day1/input.txt"))
