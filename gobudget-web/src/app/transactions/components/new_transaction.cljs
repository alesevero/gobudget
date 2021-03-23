(ns app.transactions.components.new-transaction
  (:require [re-frame.core :as rf]
            [app.components.form-group :refer [form-group]]
            [app.components.buttons :refer [primary-button]]
            [app.components.modal :refer [modal-panel]]
            [app.components.radio :refer [radio]]
            [app.transactions.components.styles :refer [modal-container
                                                        modal-title
                                                        button-container]]
            [reagent.core :as r]
            [cljs-uuid-utils.core :as uuid]))

(defn parse-transaction
  [{:keys [name value date type category]}]
  {:id (uuid/make-random-uuid)
   :name name
   :value (js/parseFloat value)
   :type type
   :date date
   :category category})

(defn new-transaction-modal
  []
  (let [values (r/atom {:value 0.0
                        :name ""
                        :date (js/Date.)
                        :type :income
                        :category ""})]
    [:div modal-container
     [:h1 modal-title "New Transaction"]
     [form-group {:id :name
                  :label "Transaction Name"
                  :type "text"
                  :values values}]
     [form-group {:id :value
                  :label "Value"
                  :type "number"
                  :values values}]
     [:div {:style {:display "flex"
                    :justify-content "flex-start"
                    :margin-bottom "16px"}}
      [radio "Income" :type :income values 1 true]
      [radio "Outcome" :type :outcome values 2 false]]
     [form-group {:id :category
                  :label "Category"
                  :type "text"
                  :values values}]
     [:div button-container
      [:button (merge {:on-click #(rf/dispatch [:create-transaction (parse-transaction @values)])}
                      primary-button)
       "Add"]]]))

(defn new-transaction []
  (let [modal (rf/subscribe [:modal])]
    (fn []
      [:div
       (when (:show? @modal)
         [modal-panel @modal])])))

(defn open-modal []
  (rf/dispatch [:modal {:show? true :child [new-transaction-modal]}]))