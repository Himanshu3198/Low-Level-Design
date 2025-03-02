The Chain of Responsibility (CoR) pattern is a behavioral design pattern that allows multiple objects (handlers) to process a request sequentially until one of them handles it.

Each handler in the chain:

Processes the request if applicable.
Passes it to the next handler if it cannot handle it.

Use this pattern when: ✅ You want to decouple the sender and receiver of a request (e.g., an ATM dispensing money).
✅ Multiple objects can handle a request, but only one should process it (e.g., logging at different levels).
✅ Requests should be processed in a specific order (e.g., a customer service ticket system).
✅ You want to avoid hardcoded conditionals (if-else or switch-case) and replace them with a dynamic chain