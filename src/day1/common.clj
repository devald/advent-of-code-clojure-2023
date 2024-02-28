(ns day1.common)

(defn extract-first-last-digits
  "This function extracts the first and last digits of a string and combines them into a two-digit number.
  For example, given the string 'example1234', the function returns the number 14."
  [string]
  (when-let [matches (re-seq #"\d" string)]
    (let [first-digit (first matches)
          last-digit (last matches)
          two-digit (str first-digit last-digit)]
      (read-string two-digit))))
