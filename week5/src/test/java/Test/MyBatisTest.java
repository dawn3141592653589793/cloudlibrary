package Test;

import com.itheima.dao.OrdersMapper;
import com.itheima.dao.PersonMapper;
import com.itheima.dao.UsersMapper;
import com.itheima.dao.WorkerMapper;
import com.itheima.pojo.Orders;
import com.itheima.pojo.Person;
import com.itheima.pojo.Users;
import com.itheima.pojo.Worker;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisTest {
    /**
     * 一对多
     */
    @Test
    public void findUserTest() {
        // 1.通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        // 2.查询id为1的用户信息
        Users users = session.selectOne("com.itheima.mapper."
                + "UsersMapper.findUserWithOrders", 1);
        // 3.输出查询结果信息
        System.out.println(users);
        // 4.关闭SqlSession
        session.close();
    }

    /**
     * 通过注解查询worker
     */
    @Test
    public void findWorkerByIdTest(){
        //通过工具类获取SqlSession对象
        SqlSession session=MyBatisUtils.getSession();
        WorkerMapper mapper=session.getMapper(WorkerMapper.class);
        //使用WorkerMapper对象查询id为1的员工信息
        Worker worker=mapper.selectWorker(1);
        System.out.println(worker.toString());
        //关闭SqlSession
        session.close();
    }

    /**
     * 通过注解插入数据
     */
    @Test
    public void insertWorkerTest(){
        //通过工具类获取SqlSession对象
        SqlSession session=MyBatisUtils.getSession();
        Worker worker =new Worker();
        worker.setId(4);
        worker.setName("赵六");
        worker.setAge(37);
        worker.setSex("女");
        worker.setWorker_id("1004");
        WorkerMapper mapper=session.getMapper(WorkerMapper.class);
        //插入员工信息
        int result= mapper.insertWorker(worker);
        if(result>0){
            System.out.println("成功插入"+result+"条数据");
        }else{
            System.out.println("插入数据失败");
        }
        System.out.println(worker.toString());
        session.commit();
        //关闭SqlSession
        session.close();
    }
    /**
     * 通过注解修改数据
     */
    @Test
    public void updateWorkerTest(){
        //通过工具类获取SqlSession对象
        SqlSession session=MyBatisUtils.getSession();
        Worker worker =new Worker();
        worker.setId(4);
        worker.setName("李华");
        worker.setAge(28);
        worker.setSex("女");
        WorkerMapper mapper=session.getMapper(WorkerMapper.class);
        //更新员工信息
        int result= mapper.insertWorker(worker);
        if(result>0){
            System.out.println("成功更新"+result+"条数据");
        }else{
            System.out.println("更新数据失败");
        }
        System.out.println(worker.toString());
        session.commit();
        //关闭SqlSession
        session.close();
    }
    /**
     * 一对一查询
     */
    @Test
    public void selectPersonByIdTest(){
        //通过工具类获取SqlSession对象
        SqlSession session=MyBatisUtils.getSession();
        PersonMapper mapper=session.getMapper(PersonMapper.class);
        // 2.查询id为1的用户信息
        Person person = mapper.selectPersonById(2);
        System.out.println(person.toString());
        // 3.关闭SqlSession
        session.close();
    }
    /**
     * 一对多查询
     */
    @Test
    public void selectUserByIdTest(){
        //通过工具类获取SqlSession对象
        SqlSession session=MyBatisUtils.getSession();
        UsersMapper mapper=session.getMapper(UsersMapper.class);
        //
        Users users=mapper.selectUserById(1);
        System.out.println(users.toString());
        //
        session.close();
    }
    /**
     * 多对多查询
     */
    @Test
    public void selectOrdersByIdTest(){
        //通过工具类获取SqlSession对象
        SqlSession session=MyBatisUtils.getSession();
        OrdersMapper mapper=session.getMapper(OrdersMapper.class);
        //
        Orders orders =mapper.selectOrdersById(1);
        System.out.println(orders.toString());
        session.close();
    }
}
