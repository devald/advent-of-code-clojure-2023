(ns day1.part2-test
  (:require [clojure.test :refer :all])
  (:require [day1.part2 :refer :all]))

(deftest sum-digit
  (is (= (read-file-and-process "src/day1/input.txt") 936)))

(comment
  (run-tests))
