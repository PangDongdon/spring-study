package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/10/18  11:00
 * @Author: dongdong
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK=null;

    public void isAlive(){
        System.out.println("yes ,i am Still Alive");
    }

    @Override
    protected  void finalize() throws  Throwable{
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK=this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK=new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        SAVE_HOOK=null;
        System.gc();
        //因为finalize 方法优先级很低，所以暂停0.5s等待他
        Thread.sleep(500);
        System.out.println(SAVE_HOOK);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no.i am dead ");
        }


        //下面这段代码与上面的代码完全相同，但是这次自救失败了
        SAVE_HOOK=null;
        System.gc();
        //因为finalize 方法优先级很低，所以暂停0.5s等待他
        Thread.sleep(500);
        System.out.println(SAVE_HOOK);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no.i am dead ");
        }



    }




}
