(ns day2.main
  (:require [clojure.string :as str]))

(defn parse-game
  "Convert the input into a two-element data structure that contains the quantity of the cube and its color."
  [game]
  (->> game
       (re-seq #"\d+|blue|green|red")
       rest
       (partition 2)))

(def limit
  "The limit of cubes per game."
  {"red"   12
   "green" 13
   "blue"  14})

(defn game-possible?
  "Returns true if the game is possible."
  [game]
  (= (count game)
     (count
       (filter
         (fn [[count color]]
           (<= (parse-long count) (limit color)))
         game))))

(defn part1
  "The solution for part 1."
  [input]
  (reduce-kv
    (fn [acc id possible?]
      (if possible?
        (+ (inc id) acc)
        acc))
    0
    (mapv game-possible? input)))

(defn part2
  "The solution for part 2."
  [input]
  (reduce
    (fn [sum game]
      (+ sum
         (->> game
              (reduce
                (fn [acc [count color]]
                  (assoc acc color (max (parse-long count) (acc color))))
                (zipmap (keys limit) (repeat (count limit) 0)))
              vals
              (apply *))))
    0
    input))

(defn read-file-and-sum
  "This function reads the contents of a file
  and takes the function to provide the sum of the game for part 1 or part 2."
  [file-path f]
  (->>
    (slurp file-path)
    (str/split-lines)
    (map parse-game)
    (f)))

(println
  "Part 1:" (read-file-and-sum "src/day2/input.txt" part1)
  "Part 2:" (read-file-and-sum "src/day2/input.txt" part2))
