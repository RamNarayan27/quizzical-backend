(ns quizzical-backend.api
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [clojure.pprint :as pp]
    [clojure.string :as str]
    [clojure.data.json :as cjson]
    [quizzical-backend.db :as db])
  (:gen-class))

(defn get-questions
  "Retrieve a list of records from questions"
  []
  (map (fn [m] (assoc {} :qid (m :qid)
                         :question (m :question)
                         :options (shuffle (conj [] (m :correct_option)
                                                 (m :w_option_1)
                                                 (m :w_option_2)
                                                 (m :w_option_3)))))
       (db/select :questions [:qid :question :correct_option :w_option_1 :w_option_2 :w_option_3])))

(defn add-question
  "Add a record to questions"
  [{ question :question correct_option :correct_option w_option_1 :w_option_1 w_option_2 :w_option_2 w_option_3 :w_option_3 :as record }]
  (db/insert :questions record))
