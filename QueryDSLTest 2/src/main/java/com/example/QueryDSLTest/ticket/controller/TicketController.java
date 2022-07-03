package com.haksik.haksikapi.ticket.controller;

import com.haksik.haksikapi.ticket.model.TicketEntity;
import com.haksik.haksikapi.ticket.model.TicketGroupView;
import com.haksik.haksikapi.ticket.model.TicketResponse;
import com.haksik.haksikapi.ticket.service.TicketService;
import com.haksik.haksikapi.user.model.UserEntity;
import com.haksik.haksikapi.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/mobileapp/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final UserService userService;

    @GetMapping("{id}")
    // @PreAuthorize("isAuthenticated()")
    public ResponseEntity<TicketResponse> readOne(@PathVariable Long id) {
        TicketEntity ticketEntity = this.ticketService.searchByTicketId(id);

        List<TicketEntity> ticketEntities = new ArrayList<>();
        ticketEntities.add(ticketEntity);

        TicketResponse ticketResponse = new TicketResponse();
        ticketResponse.setStatus("200");
        ticketResponse.setError("success");
        ticketResponse.setTicketEntities(ticketEntities);

        return ResponseEntity.ok(ticketResponse);
    }

    @GetMapping("/count")
    public ResponseEntity<TicketResponse> ticketCount(@RequestParam String email) {
        List<UserEntity> userEntities = this.userService.searchByEmail(email);

        TicketResponse ticketResponse = new TicketResponse();
        if (userEntities.size() == 0) {
            ticketResponse.setStatus("400");
            ticketResponse.setError("사용자 정보가 유효하지 않습니다");
            return ResponseEntity.ok(ticketResponse);
        }

        List<TicketEntity> ticketEntities = this.ticketService.searchTicketHaving(userEntities.get(0).getUserId());

        ticketResponse.setStatus("200");
        ticketResponse.setError("success");
        ticketResponse.setTicketTotalCount(ticketEntities.size());

        return ResponseEntity.ok(ticketResponse);
    }

    @GetMapping("/having")
    public ResponseEntity<TicketResponse> ticketHaving(@RequestParam String email) {
        List<UserEntity> userEntities = this.userService.searchByEmail(email);

        TicketResponse ticketResponse = new TicketResponse();
        if (userEntities.size() == 0) {
            ticketResponse.setStatus("400");
            ticketResponse.setError("사용자 정보가 유효하지 않습니다");
            return ResponseEntity.ok(ticketResponse);
        }

        List<TicketEntity> ticketEntities = this.ticketService.searchTicketHaving(userEntities.get(0).getUserId());
        List<TicketGroupView> ticketGroupViews = this.ticketService.searchTicketHavingGroup(userEntities.get(0).getUserId());
        ticketResponse.setStatus("200");
        ticketResponse.setError("success");
        ticketResponse.setTicketTotalCount(ticketEntities.size());
        ticketResponse.setTicketEntities(ticketEntities);
        ticketResponse.setTicketGroupViews(ticketGroupViews);

        return ResponseEntity.ok(ticketResponse);
    }

    @GetMapping("/used")
    public ResponseEntity<TicketResponse> ticketUsed(@RequestParam String email) {
        List<UserEntity> userEntities = this.userService.searchByEmail(email);

        TicketResponse ticketResponse = new TicketResponse();
        if (userEntities.size() == 0) {
            ticketResponse.setStatus("400");
            ticketResponse.setError("사용자 정보가 유효하지 않습니다");
            return ResponseEntity.ok(ticketResponse);
        }

        List<TicketEntity> ticketEntities = this.ticketService.searchTicketUsed(userEntities.get(0).getUserId());
        List<TicketGroupView> ticketGroupViews = this.ticketService.searchTicketUsedGroup(userEntities.get(0).getUserId());
        ticketResponse.setStatus("200");
        ticketResponse.setError("success");
        ticketResponse.setTicketTotalCount(ticketEntities.size());
        ticketResponse.setTicketEntities(ticketEntities);
        ticketResponse.setTicketGroupViews(ticketGroupViews);

        return ResponseEntity.ok(ticketResponse);
    }

    @GetMapping("/browse")
    public ResponseEntity<TicketResponse> ticketBrowse(@RequestParam String email, @RequestParam Long ticketid) {
        List<UserEntity> userEntities = this.userService.searchByEmail(email);

        TicketResponse ticketResponse = new TicketResponse();
        if (userEntities.size() == 0) {
            ticketResponse.setStatus("400");
            ticketResponse.setError("사용자 정보가 유효하지 않습니다");
            return ResponseEntity.ok(ticketResponse);
        }

        List<TicketEntity> ticketEntities = this.ticketService.searchTicketIdAndUserId(ticketid,userEntities.get(0).getUserId());
        ticketResponse.setStatus("200");
        ticketResponse.setError("success");
        ticketResponse.setTicketTotalCount(ticketEntities.size());
        ticketResponse.setTicketEntities(ticketEntities);

        return ResponseEntity.ok(ticketResponse);
    }

}
