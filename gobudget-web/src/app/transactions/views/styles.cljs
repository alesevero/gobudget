(ns app.transactions.views.styles)

(def container
  {:style {:width "100%"
           :max-width "1120px"
           :margin "0 auto"
           :padding "40px 40px"}})

(def card-container
  {:style {:display "grid"
           :grid-template-columns "repeat(3, 1fr)"
           :grid-gap "32px"
          ;;  :margin-top "-150px"
           }})

(defn card
  [type total]
  {:style {:background (if (= type :total)
                         (if (>= total 0)
                           "#24695C"
                           "#F9F7F6")
                         "#F9F7F6")
           :padding "22px 32px"
           :border-radius "5px"
           :color (if (= type :total)
                    "#FFFFFF"
                    "#363F5F")}})

(def card-header
  {:style {:display "flex"
           :align-items "center"
           :justify-content "space-between"}})

(def card-header-p
  {:style {:font-size "16px"}})

(def card-header-h1
  {:style {:margin-top "14px"
           :font-size "36px"
           :font-weight "normal"
           :line-height "54px"}})

(def table-container
  {:style {:margin-top "64px"
           :display "flex"
           :flex-direction "column"}})

(def table
  {:style {:width "100%"
           :border-spacing "0 8px"}})

(def table-header
  {:style {:color "#969cb3"
           :font-weight "normal"
           :padding "20px 32px"
           :text-align "left"
           :font-size "16px"
           :line-height "24px"}})

(def table-row
  {:style {:background-color "#F9F7F6"}})

(def table-data
  {:style {:padding "20px 32px"
           :font-size "16px"
           :font-weight "normal"
           :color "#969cb3"}})

(def table-data-income
  {:style (merge (:style table-data)
                 {:color "#12a454"})})

(def table-data-outcome
  {:style (merge (:style table-data)
                 {:color "#e83f5b"})})
(def table-data-title
  {:style (merge (:style table-data)
                 {:color "#363F5F"
                  :border-radius "8px 0 0 8px"})})

(def table-category
  {:style {:display "flex"}})

(def table-data-date
  {:style (merge (:style table-data)
                 {:border-radius "0 8px 8px 0"})})