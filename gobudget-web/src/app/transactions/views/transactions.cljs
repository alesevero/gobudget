(ns app.transactions.views.transactions
  (:require [app.transactions.views.styles :refer [card-container
                                                   card
                                                   card-header
                                                   card-header-p
                                                   card-header-h1
                                                   table-container
                                                   table
                                                   table-header
                                                   table-row
                                                   table-data
                                                   table-data-title
                                                   table-data-income
                                                   table-data-outcome
                                                   table-data-date
                                                   table-category]]
            [app.utils :refer [format-price format-date]]
            [re-frame.core :as rf]))

(defn calculate-total
  [transactions]
  (->> transactions
       (map (fn [{:keys [value type]}] (* value (if (= :income type) 1 -1))))
       (reduce +)))
(defn total-by-transaction-type
  [type transactions]
  (->> transactions
       (filter #(= type (:type %)))
       (map :value)
       (reduce +)))

(defn transactions
  []
  (let [transaction-history @(rf/subscribe [:transaction-history])
        total (calculate-total transaction-history)]
    [:div
     [:section card-container
      [:div (card :income 0)
       [:header card-header
        [:p card-header-p "Income"]
        [:img {:src "assets/income.svg" :alt "Income icon"}]]
       [:h1 card-header-h1
        (format-price (total-by-transaction-type
                       :income
                       transaction-history))]]
      [:div (card :outcome 0)
       [:header card-header
        [:p card-header-p "Outcome"]
        [:img {:src "assets/outcome.svg" :alt "Outcome icon"}]]
       [:h1 card-header-h1
        (format-price (total-by-transaction-type
                       :outcome
                       transaction-history))]]
      [:div (card :total total)
       [:header card-header
        [:p card-header-p "Total"]
        [:img {:src "assets/total.svg" :alt "Total icon"}]]
       [:h1 card-header-h1
        (format-price total)]]]
     [:div table-container
      [:div {:style {:display "flex"
                     :align-items "center"
                     :justify-content "space-between"}}
       [:h1 {:style {:font-size "16px"
                     :color "#24695C"}}
        "Latest Transactions"]
       [:div
        [:a {:href "#transactions"
             :on-click #(rf/dispatch [:create-transaction {:id 4
                                                           :value 8000.00
                                                           :name "Salary"
                                                           :date (js/Date.)
                                                           :type :income
                                                           :category {:name "Finance"
                                                                      :icon "dollar"}}])}
         [:img {:src "assets/plus.svg"
                :height "28px"
                :width "28px"
                :alt "Add transaction"}]]]]
      [:table table
       [:thead
        [:tr
         [:th table-header "Title"]
         [:th table-header "Price"]
         [:th table-header "Category"]
         [:th table-header "Date"]]]
       [:tbody
        (for [{:keys [id name value date type category]} transaction-history]
          [:tr (merge table-row
                      {:key id})
           [:td table-data-title name]
           [:td (case type
                  :income table-data-income
                  :outcome table-data-outcome
                  table-data-income)
            (format-price value)]
           [:td table-data
            [:div table-category
             [:img {:src (str "assets/" (:icon category) ".svg")
                    :alt "Category icon"}]
             [:p {:style {:margin-left "8px"}} (:name category)]]]
           [:td table-data-date (format-date date)]])]]]]))
