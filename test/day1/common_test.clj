(ns day1.common-test
  (:require [clojure.test :refer :all])
  (:require [day1.common :refer :all]))

(deftest extract-first-last-digits-test
  (testing "Test with one digit string"
    (are [result string] (= result (extract-first-last-digits string))
                         55 "eight5nine"
                         99 "onetwoeight9nine"
                         33 "abcsevent3fourxyz"))
  (testing "Test with more than one digit string"
    (are [result string] (= result (extract-first-last-digits string))
                         21 "six2three1"
                         22 "eleven22eight"
                         21 "six2three1")))

(comment
  (run-tests))
