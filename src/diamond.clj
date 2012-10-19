(ns diamond)
(use '[clojure.string :only (join)])

;; Builds a n x n grid with values giving by evaluating f on the coordinates
(defn grid [n f]
  (for [y (range n)] (for [x (range n)] (f x y))))

(defn taxicab-distance [[x1 y1] [x2 y2]]
  (+ (Math/abs (- x1 x2)) (Math/abs (- y1 y2))))

(defn diamond [n]
  (grid (- (* 2 n) 1)
           (fn [x y] (let [mid (- n 1) 
                           num (- n (taxicab-distance [x y] [mid mid]))]
                       (if (pos? num) num " ")))))

(defn print-diamond [n]
  (println (join "\n" (map (partial join "") (diamond n)))))