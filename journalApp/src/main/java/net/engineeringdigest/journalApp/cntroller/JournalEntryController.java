package net.engineeringdigest.journalApp.cntroller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry journalEntry){
        journalEntries.put(journalEntry.getId(),journalEntry);
        return true;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryId(@PathVariable Long myId){
       return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryId(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }

    @PutMapping("/id/{Id}")
    public JournalEntry updateJournalById(@PathVariable Long Id, @RequestBody JournalEntry myEntry){
        return journalEntries.put(Id,myEntry);
    }
}