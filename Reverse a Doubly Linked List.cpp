class Solution {
public:
    // Function to reverse a doubly linked list in-place
    Node* reverseDLL(Node* head) {
        Node* current = head;
        Node* temp = nullptr;

        // Swap next and prev pointers for all nodes of the doubly linked list
        while (current != nullptr) {
            temp = current->prev;
            current->prev = current->next;
            current->next = temp;
            current = current->prev;
        }

        // Check if the list is not empty and update the new head
        if (temp != nullptr) {
            head = temp->prev;
        }

        return head;
    }
};
