(ns day2.main-test
  (:require [clojure.test :refer :all])
  (:require [day2.main :refer :all]))

(deftest parse-game-test
  (is (= (parse-game "Game 1: 12 green, 2 blue; 9 green") '(("12" "green")
                                                            ("2" "blue")
                                                            ("9" "green")))))

(deftest game-possible?-test
  (testing "Game possible"
    (is (true? (game-possible? '(("12" "green")
                                 ("2" "blue")
                                 ("9" "green"))))))
  (testing "Game impossible"
    (is (false? (game-possible? '(("14" "green")
                                  ("2" "blue")
                                  ("9" "green")))))))

(deftest part1-test
  (is (=
        (read-file-and-sum "src/day2/input.txt" part1)
        8)))

(deftest part2-test
  (is (=
        (read-file-and-sum "src/day2/input.txt" part2)
        2286)))

(comment
  (run-tests))
