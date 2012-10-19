(ns diamond)
(use '[clojure.string :only (join)])

(defn grid 
  "Builds a n x n grid with values giving by evaluating f on the coordinates"
  [n f]
  (let [size (- (* 2 n) 1)]
    (for [y (range size)]
      (for [x (range size)] (f x y)))))

(defn taxicab-distance [[x1 y1] [x2 y2] ]
  (+ (Math/abs (- x1 x2)) (Math/abs (- y1 y2))))

(defn diamond [n]
  (grid n (fn [x y] (let [mid (- n 1) 
                          num (- n (taxicab-distance [x y] [mid mid]))]
                      (if (pos? num) num " ")))))

(defn print-diamond [n]
  (println (join "\n" (map (partial join "") (diamond n)))))