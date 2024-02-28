(ns day1.part2-test
  (:require [clojure.test :refer :all])
  (:require [day1.part2 :refer :all]))

(deftest convert-word-to-number-test
  (are [result string] (= result (convert-word-to-number string))
                       "18" "oneight"
                       "21" "twone"
                       "38" "threeight"))

(deftest read-file-and-sum-test
  (is (= (read-file-and-sum "src/day1/input.txt") 936)))

(comment
  (run-tests))
