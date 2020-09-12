package generate;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * order_event
 * @author 
 */
@Data
public class OrderEvent implements Serializable {
    private Integer id;

    private String orderType;

    private String process;

    private String content;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}