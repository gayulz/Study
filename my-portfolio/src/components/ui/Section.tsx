import { ReactNode } from "react";
import { cn } from "../../lib/utils";

interface SectionProps {
  children: ReactNode;
  className?: string;
  id?: string;
}

export default function Section({ children, className, id }: SectionProps) {
  return (
    <section 
      id={id} 
      className={cn("w-full max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-20 md:py-32", className)}
    >
      {children}
    </section>
  );
}
