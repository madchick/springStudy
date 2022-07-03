package com.haksik.haksikapi.ticket.service;

import com.haksik.haksikapi.ticket.model.TicketEntity;
import com.haksik.haksikapi.ticket.model.TicketGroupView;
import com.haksik.haksikapi.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketEntity add(TicketEntity ticketEntity) {
        return this.ticketRepository.save(ticketEntity);
    }

    public List<TicketEntity> searchAll() {
        return this.ticketRepository.findAll();
    }

    public List<TicketEntity> searchAllByUserId(Long userId) {
        return this.ticketRepository.findAllByUserId(userId);
    }

    public List<TicketEntity> searchTicketHaving(Long userId) {
        return this.ticketRepository.findTicketHaving(userId);
    }
    public List<TicketGroupView> searchTicketHavingGroup(Long userId) {
        return this.ticketRepository.findTicketHavingGroup(userId);
    }

    public List<TicketEntity> searchTicketUsed(Long userId) {
        return this.ticketRepository.findTicketUsed(userId);
    }
    public List<TicketGroupView> searchTicketUsedGroup(Long userId) {
        return this.ticketRepository.findTicketUsedGroup(userId);
    }

    public List<TicketEntity> searchTicketIdAndUserId(Long ticketId, Long userId) {
        return this.ticketRepository.findByTicketIdAndUserId(ticketId, userId);
    }

    public TicketEntity searchByTicketId(Long ticketId) {
        return this.ticketRepository.findByTicketId(ticketId);
    }

}
