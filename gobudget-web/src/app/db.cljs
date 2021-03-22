(ns app.db
  (:require [re-frame.core :as rf]))

(def initial-app-db {:auth {:uid nil}
                     :errors {}
                     :nav {:active-page :sign-in
                           :active-nav :sign-in
                           :active-modal nil
                           :active-recipe nil
                           :active-inbox nil}
                     :transaction-history [{:id 1
                                            :value 8000.00
                                            :name "Salary"
                                            :date (js/Date.)
                                            :type :income
                                            :category {:name "Finance"
                                                       :icon "dollar"}}
                                           {:id 2
                                            :value 45.00
                                            :name "Netflix"
                                            :date (js/Date.)
                                            :type :outcome
                                            :category {:name "Entertainment"
                                                       :icon "home"}}
                                           {:id 3
                                            :value 9.90
                                            :name "Amazon Prime"
                                            :date (js/Date.)
                                            :type :outcome
                                            :category {:name "Entertainment"
                                                       :icon "home"}}]
                     :users {"mike@mailinator.com" {:uid "mike@mailinator.com"
                                                    :profile {:first-name "Mike"
                                                              :last-name "Jordan"
                                                              :img "https://res.cloudinary.com/schae/image/upload/f_auto,h_400,q_80/v1548196567/cheffy/mike.jpg"
                                                              :email "mike@mailinator.com"
                                                              :password "password"}
                                                    :role :user
                                                    :saved #{}
                                                    :inboxes {"jade@mailinator.com" {:id :inbox-01
                                                                                     :updated-at 1538697210534
                                                                                     :notifications 3}
                                                              "mark@mailinator.com" {:id :inbox-02
                                                                                     :notifications 6
                                                                                     :updated-at 1538697210537}}}}})

(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   initial-app-db))