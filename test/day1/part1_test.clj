(ns day1.part1-test
  (:require [clojure.test :refer :all])
  (:require [day1.part1 :refer :all]))

(deftest read-file-and-sum-test
  (is (= (read-file-and-sum "src/day1/input.txt") 702)))

(comment
  (run-tests))
