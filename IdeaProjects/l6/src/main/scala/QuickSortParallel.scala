object QuickSortParallel{

  def swap(tab : Array[Int], i : Int, j : Int) : Unit={
    val aux = tab(i)
    tab(i)=tab(j)
    tab(j)=aux
  }

  def choosePivot(tab : Array[Int], m : Int, n : Int) : Int={
    tab((m+n)/2)
  }

  def partitionParallel(tab : Array[Int], l : Int, r : Int) : (Int, Int)={
    var i=l
    var j=r
    val pivot=choosePivot(tab, l, r)
    while(i<=j){
      while(tab(i)<pivot) i+=1
      while(tab(j)>pivot) j-=1
      if(i<=j){
        swap(tab, i, j)
        i+=1
        j-=1
      }
    }
    (i, j)
  }

  def quickParallel(tab : Array[Int], l : Int, r : Int) : Unit={
    if(l<r){
      val (i, j)=partitionParallel(tab : Array[Int], l : Int, r : Int)
      if(j-l<r-i){
        ParallelUtil.parallel(quickParallel(tab, l, j), quickParallel(tab, i, r))
      }
      else{
        ParallelUtil.parallel(quickParallel(tab, i, r), quickParallel(tab, l, j))
      }
    }
  }


  def quickSortParallel(tab : Array[Int]) : Unit={
    quickParallel(tab, 0, tab.length-1)
  }
}