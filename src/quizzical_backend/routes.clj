(ns quizzical-backend.routes
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [clojure.pprint :as pp]
    [clojure.string :as str]
    [clojure.data.json :as json]
    [quizzical-backend.api :as api])
  (:gen-class))

(defn echo-route
  "Echo back the request"
  [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (-> (str "GET '/' " req))})

(defn get-questions-route
  "Endpoint for getting all questions"
  [req]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (-> (api/get-questions))})

(defn add-question-route
  "Endpoint for adding a question"
  [req]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (-> (api/add-question (req :params)))})
