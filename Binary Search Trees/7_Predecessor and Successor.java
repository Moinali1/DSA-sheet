public static void findPreSuc(Node root, int key)
{
    Node preItr=root;
    Node sucItr=root;
  while(preItr!=null)
  {
      if(preItr.data>=key) preItr=preItr.left;
      else if(preItr.data<key){
          pre=preItr;
          preItr=preItr.right;
      }
  }
  while(sucItr!=null)
  {
      if(sucItr.data<=key)sucItr=sucItr.right;
      else if(sucItr.data>key){
          suc=sucItr;
          sucItr=sucItr.left;
      }
  }
}
}