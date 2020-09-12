package generate;

public interface OrderEventDao {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderEvent record);

    int insertSelective(OrderEvent record);

    OrderEvent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderEvent record);

    int updateByPrimaryKey(OrderEvent record);
}