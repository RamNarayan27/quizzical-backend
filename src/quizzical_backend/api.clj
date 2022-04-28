(ns quizzical-backend.api
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [clojure.pprint :as pp]
    [clojure.string :as str]
    [clojure.data.json :as cjson]
    [clj-http.client :as client]
    [clojure.data.json :as json]
    [quizzical-backend.db :as db])
  (:gen-class))

(defn get-questions
  "Retrieve the list of records from questions"
  []
  ; get the questions from the open trivia db - DONE
  ; add the questions to db - DONE
  ; take 5 random questions from the db - DONE
  (map (fn [m] (assoc {} :qid (m :qid)
                         :question (m :question)
                         :options (shuffle (conj [] (m :correct_option)
                                                 (m :w_option_1)
                                                 (m :w_option_2)
                                                 (m :w_option_3)))))
       (take 5 (shuffle (db/select :questions_all_1 [:qid :question :correct_option :w_option_1 :w_option_2 :w_option_3])))))

(defn get-questions-from-trivia-db-api-and-add-to-db
  "Get the questions from the OpenTriviaDB"
  []
  (map (fn [{ question :question
             correct_option :correct_option
             w_option_1 :w_option_1
             w_option_2 :w_option_2
             w_option_3 :w_option_3 :as record}]
         (db/insert :questions_all_1 record))
       (map (fn [m] (assoc {} :question (m "question")
                              :correct_option (m "correct_answer")
                              :w_option_1 ((m "incorrect_answers") 0)
                              :w_option_2 ((m "incorrect_answers") 1)
                              :w_option_3 ((m "incorrect_answers") 2)))
            ((json/read-str
               ((client/get
                  "https://opentdb.com/api.php?amount=5&type=multiple") :body)) "results")))


  )

(defn add-question
  "Add a record to questions"
  [{ question :question correct_option :correct_option w_option_1 :w_option_1 w_option_2 :w_option_2 w_option_3 :w_option_3 :as record }]
  (db/insert :questions_all_1 record))
