;; ESTree Spec
;; https://github.com/estree/estree

(ns lambda-view.javascript.expression.t-logical
  (:use [lambda-view.javascript.render :only [render-exp-node]]
        [lambda-view.common :only [js-keyword
                                   white-space
                                   white-space-optional
                                   asterisk
                                   comma
                                   common-list
                                   operator
                                   collapsable-box]]
        [lambda-view.tag :only [id-of]]
        [lambda-view.state :only [init-collapse!
                                  init-layout!]]))

;; LogicalExpression
(defn render [node]
  (let [op (get node "operator")
        left (get node "left")
        right (get node "right")]
    [:div.logical.expression
     (render-exp-node left node)
     (white-space-optional)
     (operator op)
     (white-space-optional)
     (render-exp-node right node)]))

(def demo ["a || b;"
           "a && b;"])
