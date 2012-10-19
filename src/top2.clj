(ns top2)

(defn top-two [[big1 big2 :as coll] n]
    (cond
      (or (nil? big1) (> n big1)) [n big1]
      (or (nil? big2) (> n big2)) [big1 n]
      :else coll))

(defn top-two-list [coll]
  (reduce top-two [] coll))