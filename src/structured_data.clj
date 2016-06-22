(ns structured-data)

(defn do-a-thing [x]
  (let [dubx (+ x x)]
    (Math/pow dubx dubx)))

(defn spiff [v]
  (+ (get v 0) (get v 2)))

(defn cutify [v]
  (conj v "<3"))

(defn spiff-destructuring [v]
  (let [ [one two three] v]
    (+ one three)))

(defn point [x y]
  [x y])

(defn rectangle [bottom-left top-right]
  [bottom-left top-right])

(defn width [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (- x2 x1)))

(defn height [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (- y2 y1)))

(defn square? [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (if (== (- y2 y1) (- x2 x1)) true false)))

(defn area [rectangle]
  (let [[[x1 y1] [x2 y2]] rectangle]
    (* (- y2 y1) (- x2 x1))))

(defn contains-point? [rectangle point]
  (let [[[x1 y1] [x2 y2]] rectangle [px py] point]
    (if (and (<= x1 px x2) (<= y1 py y2)) true false)))

(defn contains-rectangle? [outer inner]
  (let [[[out-x1 out-y1] [out-x2 out-y2]] outer
        [[in-x1 in-y1] [in-x2 in-y2]] inner]
    (if (and (<= out-x1 in-x1 in-x2 out-x2) (<= out-y1 in-y1 in-y2 out-y2)) true false)))

(defn title-length [book]
  (count (:title book)))

(defn author-count [book]
  (count (:authors book)))

(defn multiple-authors? [book]
  (if (> (author-count book) 1) true false))

(defn add-author [book new-author]
  (let [authors (:authors book)]
    (assoc book :authors (conj authors new-author))))

(defn alive? [author]
  (if (contains? author :death-year) false true))

(defn element-lengths [collection]
  (map count collection))

(defn second-elements [collection]
  (let [two-getty (fn [x] (get x 1))]
    (map two-getty collection)))

(defn titles [books]
  (map :title books))

(defn monotonic? [a-seq]
  (if (or (apply <= a-seq) (apply >= a-seq)) true false))

(defn stars [n]
  (apply str (repeat n \*)))

(defn toggle [a-set elem]
  (cond (contains? a-set elem) (disj a-set elem)
        :else (conj a-set elem)))

(defn contains-duplicates? [a-seq]
  (if (== (count a-seq) (count (set a-seq))) false true))

(defn old-book->new-book [book]
  (let [old-authors (:authors book)]
    (assoc book :authors (set old-authors))))

(defn has-author? [book author]
  (contains? (:authors book) author))

(defn authors [books]
  (set (apply concat (map :authors books))))

(defn all-author-names [books]
  (set (map :name (authors books))))

(defn author->string [author]
  :-)

(defn authors->string [authors]
  :-)

(defn book->string [book]
  :-)

(defn books->string [books]
  :-)

(defn books-by-author [author books]
  :-)

(defn author-by-name [name authors]
  :-)

(defn living-authors [authors]
  :-)

(defn has-a-living-author? [book]
  :-)

(defn books-by-living-authors [books]
  :-)

; %________%

(def china {:name "China Miéville", :birth-year 1972})
(def octavia {:name "Octavia E. Butler"
              :birth-year 1947
              :death-year 2006})
(def friedman {:name "Daniel Friedman" :birth-year 1944})
(def felleisen {:name "Matthias Felleisen"})

(def cities {:title "The City and the City" :authors #{china}})
(def wild-seed {:title "Wild Seed", :authors #{octavia}})
(def embassytown {:title "Embassytown", :authors #{china}})
(def little-schemer {:title "The Little Schemer"
                     :authors #{friedman, felleisen}})

(def books [cities, wild-seed, embassytown, little-schemer])

