package show;

import show.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ShowStatusViewHandler {


    @Autowired
    private ShowStatusRepository showStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBooked_then_CREATE_1 (@Payload Booked booked) {
        try {
            if (booked.isMe()) {
                // view 객체 생성
                ShowStatus showStatus = new ShowStatus();
                // view 객체에 이벤트의 Value 를 set 함
                showStatus.setId(booked.getId());
                // view 레파지 토리에 save
                showStatusRepository.save(showStatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayed_then_UPDATE_1(@Payload Payed payed) {
        try {
            if (payed.isMe()) {
                // view 객체 조회
                Optional<ShowStatus> showStatusOptional = showStatusRepository.findById(payed.getBookId());
                if( showStatusOptional.isPresent()) {
                    ShowStatus showStatus = showStatusOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    showStatus.setPayStatus(payed.getStatus());
                    // view 레파지 토리에 save
                    showStatusRepository.save(showStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceled_then_UPDATE_2(@Payload Canceled canceled) {
        try {
            if (canceled.isMe()) {
                // view 객체 조회
                Optional<ShowStatus> showStatusOptional = showStatusRepository.findById(canceled.getBookId());
                if( showStatusOptional.isPresent()) {
                    ShowStatus showStatus = showStatusOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    showStatus.setPayStatus(canceled.getStatus());
                    // view 레파지 토리에 save
                    showStatusRepository.save(showStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenIssueStatusChanged_then_UPDATE_3(@Payload IssueStatusChanged issueStatusChanged) {
        try {
            if (issueStatusChanged.isMe()) {
                // view 객체 조회
                Optional<ShowStatus> showStatusOptional = showStatusRepository.findById(issueStatusChanged.getBookId());
                if( showStatusOptional.isPresent()) {
                    ShowStatus showStatus = showStatusOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    showStatus.setIssueStatus(issueStatusChanged.getIssueStatus());
                    // view 레파지 토리에 save
                    showStatusRepository.save(showStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenIssued_then_UPDATE_4(@Payload Issued issued) {
        try {
            if (issued.isMe()) {
                // view 객체 조회
                Optional<ShowStatus> showStatusOptional = showStatusRepository.findById(issued.getBookId());
                if( showStatusOptional.isPresent()) {
                    ShowStatus showStatus = showStatusOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    showStatus.setIssueStatus(issued.getIssueStatus());
                    // view 레파지 토리에 save
                    showStatusRepository.save(showStatus);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookingCanceled_then_DELETE_1(@Payload BookingCanceled bookingCanceled) {
        try {
            if (bookingCanceled.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                showStatusRepository.deleteByBookId(bookingCanceled.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}