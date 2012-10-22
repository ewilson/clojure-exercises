(ns words)

(use '[clojure.string :only (join split)])

(defn stutter [s]
  (join " " (mapcat (fn [w] [w w]) (split s #" "))))

