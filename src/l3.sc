//Lista 3 Maciej Kopiński

//ZADANIE 1



//ZADANIE 2

def listLength[A](xs: List[A]): Int=
  if(xs==Nil) 0
  else 1+listLength(xs.tail)

listLength(List(1, 2, 3, 4))==4;
listLength(List())==0;

//ZADANIE 3

def mergeTwoLists[A](xs: List[A], ys: List[A]): List[A]={
  (xs, ys) match{
    case (Nil, Nil)=> Nil
    case (Nil, _)=> ys
    case (_, Nil)=> xs
    case(h1::t1, h2::t2)=> h1::h2::mergeTwoLists(t1, t2)
  }
}

mergeTwoLists(List(), List())==List();
mergeTwoLists(List(5, 4, 3, 2), List(1, 2, 3, 4, 5, 6))==List(5, 1, 4, 2, 3, 3, 2, 4, 5, 6);
mergeTwoLists(List(1, 2, 3), List())==List(1, 2, 3);

//ZADANIE 4



//ZADANIE 5


