(ns moon-dweller.state)

(def current-room (ref 0))             ; Current room the player is in.
(def visited-rooms (ref []))           ; Rooms that the player has visited.
(def inventory (ref []))               ; Players inventory of items.
(def credits (ref 0))                  ; Players credits (aka $$$).
(def milestones (ref #{}))             ; Players milestones. Used to track and manipulate story.
(def game-options (ref {:retro true    ; Print to stdout with tiny pauses between characters.
                        :sound true})) ; Play sound during gameplay.

; A vector containing the objects that each room contains when the game starts. Each index
; corresponds to the room as defined in 'rooms'.
(def room-objects
  (ref
    (vector
      [0 1]        ;0
      []           ;1
      [2]          ;2
      []           ;3
      []           ;4
      []           ;5
      []           ;6
      [7]          ;7
      []           ;8
      []           ;9
      [8]          ;10
      [9 10]       ;11
      [11]         ;12
      []           ;13
      []           ;14
      [12 13 14]   ;15
      [18]         ;16
      [15 16 17]   ;17
      []           ;18
      [20]         ;19
      []           ;20
      [21 22 26]   ;21
      []           ;22
      [23]         ;23
      []           ;24
      []           ;25
      [27]         ;26
      [25]         ;27
      [24]         ;28
      []           ;29
      [])))        ;30

; Specifies the verbs that users can identify an object with (a gun might
; be "gun", "weapon", etc). A set means that the given term may refer to
; multiple objects. The system will try to deduce the correct object when
; a command is entered. Each index corresponds to the same index in room-objects.
(def object-identifiers
    {'candy 0 'bar 0 'bed 1 'lever 2 'mag 3 'magazine 3 'porno 3 'boy 7
     'teenager 7 'keycard #{4 5 6} 'key #{4 5 6} 'man #{8 9 21 22 23} 'robot 10
     'green #{4 13} 'red #{5 12} 'brown 14 'silver 6 'bum 11 'potion #{12 13 14}
     'credits 18 'attendant 15 'woman 15 'salvika 16 'whisky 16 'becherovka 17
     'web 20 'knife 19 'small 19 'thin 22 'skinny 22 'fat 21 'paper 24 'book 25
     'stone 26 'rock 26})
