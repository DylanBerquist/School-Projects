(defun f1 (L)
  (cond ((null L) 0)                             ;if L is null, return 0
        ((listp (car L)) (+ 1 (f1 (cdr L))))     ;if first element is a list, add 1
        (T (f1 (cdr L)))                         ; if not a list, keep going without adding
  )
)
(defun f2 (L)
  (cond ((null L) nil)         ;if L is null, return empty list
        ((atom (car L)) T)     ;as soon as you find an atom, return true
        (T (f2 (cdr L)))       ;else, keeping going with the rest of the list
  )
)
(defun f3 (L)
  (cond ((null L) nil)                                 ;if L is null, return empty list
        ((oddp (car L)) (cons (car L) (f3 (cdr L))))   ;if first element is odd, add it to the-
                                                       ;return value of the next function call
        (T (f3(cdr L)))                                ; else, keeping going with the rest
  )
)
(defun f4 (L)
  (cond ((null (cdr L)) (car L))              ;if there's only one element, return it
        ((< (car L) (f4 (cdr L))) (car L))    ;if first element is less than the rest, return it
        (T (f4 (cdr L)))                      ;if not, keep going with the rest
  )
)
(defun f5 (L)
  (cond ((null L) nil)                            ;if L is null, return empty list
        (T (append (f5 (cdr L)) (list (car L))))  ;append the rest of the list (reversed) with-
                                                  ;the first element
  )
)
(defun f6 (L)
  (cond ((null L) nil)                   ;if L is empty, return empty list
        ((cons (car L) (f6 (cddr L))))   ;create a list with the first element, and the following-
                                         ;every other elements
  )
)
(defun f7 (L n)
  (cond ((null L) nil)               ;if L is null, return empty list
        ((equal n 0) (car L))        ;if n is 0, return the current element
        (T (f7 (cdr L) (- n 1)))     ;else, continue through the list, and decrement n
  )
)
(defun f8 (L)
  (cond ((null L) 1)                                     ;if L is null, return 1
        ((listp (car L)) (* (f8 (car L)) (f8 (cdr L))))  ;if current element is a list, find the-
                                                         ;product of that list 
        ((atom (car L)) (* (car L) (f8 (cdr L))))        ;if it's an atom, just multiply
        (T (f8 (cdr L)))                                 ;else, just ignore it
  )
)
(defun my_member (x L)               ;function copied from the notes to include lists into the member function
  (cond ((null L) nil)
        ((equal x (car L)) T)
        (T (my_member x (cdr L)))
  )
)
(defun f9 (L)
  (cond ((null L) nil)                                                   ;if L is null, return an empty list
        ((not (my_member (car L) (cdr L))) (cons (car L) (f9 (cdr L))))  ;if current element is NOT a member of the rest,
                                                                         ;add it to the list
        (T (f9 (cdr L)))                                                 ;else keep going with the rest
  )
)
(defun f10 (L I)
  (cond ((null L) nil)                                          ;if either lists are null, return empty list
        ((null I) nil)
        ((my_member (car L) I) (cons (car L) (f10 (cdr L) I)))  ;if current element of L is a member of I, add-
                                                                ;it to the list
        (T (f10 (cdr L) I))                                     ;else, keep going through L, keeping I the same
  )
)