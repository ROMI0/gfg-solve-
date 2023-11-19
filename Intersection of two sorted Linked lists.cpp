class Solution
{
public:
    Node *findIntersection(Node *head1, Node *head2)
    {
        // Initialize a dummy node for the result linked list.
        Node *dummy = new Node(0);
        Node *temp = dummy;

        // Traverse both linked lists while there are nodes in both.
        while (head1 != nullptr && head2 != nullptr)
        {
            // If the data at the current node in both lists is the same,
            // add it to the result linked list.
            if (head1->data == head2->data)
            {
                temp->next = new Node(head1->data);
                temp = temp->next;
                head1 = head1->next;
                head2 = head2->next;
            }
            // If the data in the first list is smaller, move to the next node in the first list.
            else if (head1->data < head2->data)
            {
                head1 = head1->next;
            }
            // If the data in the second list is smaller, move to the next node in the second list.
            else
            {
                head2 = head2->next;
            }
        }

        // The dummy node was used to simplify the logic. The actual result starts from dummy->next.
        return dummy->next;
    }
};
