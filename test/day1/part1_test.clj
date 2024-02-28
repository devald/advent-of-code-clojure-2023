(ns day1.part1-test
  (:require [clojure.test :refer :all])
  (:require [day1.part1 :refer :all]))

(deftest sum-digit
  (is (= (read-file-and-process "src/day1/input.txt") 702)))

(comment
  (run-tests))
