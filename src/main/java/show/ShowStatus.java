package show;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ShowStatus_table")
public class ShowStatus {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String payStatus;
        private String issueStatus;
        private String showName;
        private Integer payAmount;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(String payStatus) {
            this.payStatus = payStatus;
        }
        public String getIssueStatus() {
            return issueStatus;
        }

        public void setIssueStatus(String issueStatus) {
            this.issueStatus = issueStatus;
        }
        public String getShowName() {
            return showName;
        }

        public void setShowName(String showName) {
            this.showName = showName;
        }
        public Integer getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(Integer payAmount) {
            this.payAmount = payAmount;
        }

}
